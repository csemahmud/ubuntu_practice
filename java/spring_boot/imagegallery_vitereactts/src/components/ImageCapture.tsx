import React, { useRef, useState } from 'react';
import Webcam from 'react-webcam';
import * as XLSX from 'xlsx';
import { saveAs } from 'file-saver';
import { IImageData } from '../models/IImageData.type';

const ImageCapture: React.FC = () => {
  const webcamRef = useRef<Webcam>(null);
  const [imagesData, setImagesData] = useState<IImageData[]>([]);

  const capture = React.useCallback(async () => {
    if (webcamRef.current) {
      // Capture the screenshot as a base64 string
    const base64Image = webcamRef.current?.getScreenshot();
    if (!base64Image) return;

      if (base64Image) {

        // Convert base64 to Blob
        const blob = base64ToBlob(base64Image, "image/jpeg");

        // Create a File object from the Blob
        const imageFile = new File([blob], `image_${Date.now()}.jpeg`, { type: "image/jpeg" });

        // Get image dimensions
        const dimensions = await getImageDimensions(base64Image);

        // Prepare image data
        const newImageData = {
          id: Date.now(),
          image_name: imageFile.name,
          path: `src/images/${imageFile.name}`,
          size: imageFile.size,
          height: dimensions.height,
          width: dimensions.width,
        };

        // Save the image in "images" folder (for demo, using local client-side)
        saveAs(blob, newImageData.image_name);

        // Update image data array
        setImagesData((prev) => [...prev, newImageData]);

        // Update Excel file
        saveToExcel(newImageData);
      }
    }
  }, [webcamRef]);

  // Helper function to convert base64 to Blob
  const base64ToBlob = (base64Data: string, contentType: string) => {
    const byteCharacters = atob(base64Data.split(",")[1]);
    const byteNumbers = new Array(byteCharacters.length).fill(0).map((_, i) => byteCharacters.charCodeAt(i));
    const byteArray = new Uint8Array(byteNumbers);
    return new Blob([byteArray], { type: contentType });
  };

  // Helper function to get image dimensions
  const getImageDimensions = (base64: string): Promise<{ width: number; height: number }> => {
    return new Promise((resolve) => {
      const img = new Image();
      img.onload = () => resolve({ width: img.width, height: img.height });
      img.src = base64;
    });
  };

  const saveToExcel = (newImageData: IImageData) => {
    try {
      // Initialize workbook
      let workbook;
      try {
        // Try reading existing workbook
        workbook = XLSX.readFile('src/docs/Data.xlsx');
  
        // Get the existing worksheet
        const sheet = workbook.Sheets['Sheet1'];
        const existingData = XLSX.utils.sheet_to_json(sheet);
    
        // Append new data
        existingData.push(newImageData);
    
        // Write updated data back to worksheet
        const updatedSheet = XLSX.utils.json_to_sheet(existingData);
        workbook.Sheets['Sheet1'] = updatedSheet;
    
        // Save workbook back to file
        XLSX.writeFile(workbook, 'src/docs/Data.xlsx');
      } catch {
        // If file doesn't exist, create a new workbook and sheet
        const ws = XLSX.utils.json_to_sheet(JSON.parse(JSON.stringify([newImageData])));
        const wb = XLSX.utils.book_new();
        XLSX.utils.book_append_sheet(wb, ws, 'Image Data');

        const excelBuffer = XLSX.write(wb, { bookType: 'xlsx', type: 'array' });
        const blob = new Blob([excelBuffer], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });

        saveAs(blob, 'Data.xlsx');
      }
    } catch (error) {
      console.error('Error saving data to Excel:', error);
    }
  };

  return (
    <div>
      <Webcam
        audio={false}
        ref={webcamRef}
        screenshotFormat="image/png"
        videoConstraints={{
          width: 1280,
          height: 720,
          facingMode: "user", // this might default to OBS virtual camera
        }}
      />
      <button onClick={capture}>Capture Image</button>
      <div>
        <h3>Captured Images</h3>
        <ul>
          {imagesData.map((img) => (
            <li key={img.id}>
              {img.image_name} - {img.path}
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default ImageCapture;
