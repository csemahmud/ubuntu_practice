export interface IImageData {

    id: number;
    image_name: string;
    path: string;
    size?: number; // size in bytes
    dimensions?: { width: number; height: number };
    
}