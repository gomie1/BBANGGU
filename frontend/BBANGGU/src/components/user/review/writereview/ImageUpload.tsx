import React, { useState } from 'react';
import { Camera } from 'lucide-react';
import { useRef } from 'react';

interface ImageUploadProps {
  images: File[];
  onImagesChange: (files: File[]) => void;
}

export const ImageUpload: React.FC<ImageUploadProps> = ({ images, onImagesChange }) => {
  const [previewUrl, setPreviewUrl] = useState<string | null>(null);
  const fileInputRef = useRef<HTMLInputElement>(null);

  const handleImageChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const file = e.target.files?.[0];
    if (file) {
      if (file.size > 5 * 1024 * 1024) {
        alert('파일 크기는 5MB 이하여야 합니다.');
        return;
      }
  
      if (!file.type.startsWith('image/')) {
        alert('이미지 파일만 업로드 가능합니다.');
        return;
      }
  
      const reader = new FileReader();
      reader.onloadend = () => {
        // 미리보기 URL 설정
        setPreviewUrl(reader.result as string);
        // 선택된 파일을 부모 컴포넌트에 전달합니다.
        onImagesChange([file]);
      };
      reader.readAsDataURL(file);
    }
  };

  const removeImage = (index: number) => {
    onImagesChange(images.filter((_, i) => i !== index));
  };

  return (
    <div className="space-y-4">
      <div className="flex flex-wrap gap-2">
        {images.map((image, index) => (
          <div key={index} className="relative w-20 h-20">
            <img
              src={URL.createObjectURL(image)}
              alt={`Preview ${index}`}
              className="w-full h-full object-cover rounded-xl"
            />
            <button
              type="button"
              onClick={() => removeImage(index)}
              className="absolute -top-2 -right-2 bg-gray-800 rounded-full w-5 h-5 flex items-center justify-center text-white text-sm"
            >
              ×
            </button>
          </div>
        ))}
        {images.length < 5 && (
          <label 
            className="w-20 h-20 border-2 border-dashed border-gray-300 rounded-xl flex items-center justify-center cursor-pointer"
          >
            <Camera className="w-6 h-6 text-gray-400" />
            <input
              type="file"
              ref={fileInputRef}
              onChange={handleImageChange}
              accept="image/*"
              multiple
              className="hidden"
            />
          </label>
        )}
      </div>
      <p className="text-sm text-gray-500">
        최대 5장까지 업로드 가능합니다
      </p>
      {previewUrl && (
        <div className="mt-2">
          <img src={previewUrl} alt="미리보기" className="max-w-xs max-h-64" />
        </div>
      )}
    </div>
  );
}; 