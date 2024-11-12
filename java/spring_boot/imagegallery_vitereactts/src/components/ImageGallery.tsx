import React, { useEffect, useState } from 'react';
import * as XLSX from 'xlsx';
import { IImageData } from '../models/IImageData.type';

const ImageGallery: React.FC = () => {
  const [images, setImages] = useState<IImageData[]>([]);

  useEffect(() => {
    // Function to read the Excel file
    const fetchData = async () => {
      const response = await fetch('/src/docs/Data.xlsx');
      const arrayBuffer = await response.arrayBuffer();
      const workbook = XLSX.read(arrayBuffer, { type: 'array' });
      const worksheet = workbook.Sheets[workbook.SheetNames[0]];
      const data: IImageData[] = XLSX.utils.sheet_to_json(worksheet);

      const enrichedData = await Promise.all(
        data.map(async (image) => {
          const imageInfo = await getImageInfo(image.path);
          return { ...image, ...imageInfo };
        })
      );

      setImages(enrichedData);
    };

    fetchData();
  }, []);

  // Function to retrieve image size and dimensions
  const getImageInfo = async (path: string): Promise<{ size: number; dimensions: { width: number; height: number } }> => {
    const response = await fetch(path);
    const blob = await response.blob();
    const size = blob.size;

    return new Promise((resolve) => {
      const img = new Image();
      img.src = URL.createObjectURL(blob);
      img.onload = () => {
        const dimensions = { width: img.width, height: img.height };
        resolve({ size, dimensions });
      };
    });
  };

  return (
    <div>
      <h2>Image Gallery</h2>
      <div style={{ display: 'flex', flexWrap: 'wrap', gap: '10px' }}>
        {images.map((image) => (
          <div key={image.id} style={{ border: '1px solid #ddd', padding: '10px', width: '200px' }}>
            <img src={image.path} alt={image.image_name} style={{ width: '100%', height: 'auto' }} />
            <div>
              <p><strong>Name:</strong> {image.image_name}</p>
              <p><strong>Size:</strong> {(image.size ?? 0 / 1024).toFixed(2)} KB</p>
              <p><strong>Dimensions:</strong> {image.dimensions?.width} x {image.dimensions?.height}</p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default ImageGallery;
