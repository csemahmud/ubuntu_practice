import React, { useEffect, useState } from 'react';
import * as XLSX from 'xlsx';
import { Dropdown, DropdownButton } from 'react-bootstrap';
import utilitiesFile from '../docs/Utilities.xlsx';

interface ExcelDropdownProps {
  domain: string;                 // Current selected domain
  setDomain: React.Dispatch<React.SetStateAction<string>>; // Setter function for domain
}

const ExcelDropdown: React.FC<ExcelDropdownProps> = ({ domain, setDomain }) => {
  const [dropdownItems, setDropdownItems] = useState<string[]>([]);
  const [selectedItem, setSelectedItem] = useState<string>(domain || "Select a Domain");

  // Function to load and parse the Excel file
  // eslint-disable-next-line react-hooks/exhaustive-deps
  const loadExcelData = async () => {
    const response = await fetch(utilitiesFile);
    const data = await response.arrayBuffer();
    const workbook = XLSX.read(data, { type: 'array' });
    const sheetName = workbook.SheetNames[0];
    const worksheet = workbook.Sheets[sheetName];
  
    // Convert worksheet to JSON with header row detection
    const jsonData = XLSX.utils.sheet_to_json(worksheet, { header: 1 }) as string[][];

    console.log(jsonData);
  
    // Find the index of the "Domains" column
    const headerRow = jsonData[3]; // Assuming the header row is the 4th row (index 3)
    const domainIndex = headerRow.indexOf("Domains");
  
    if (domainIndex === -1) {
      console.error("Domains column not found in the Excel sheet");
      return;
    }
  
    // Extract all items from the "Domains" column, starting from the row after the header
    const domainData = jsonData
    .slice(4) // Skip the header row
    .map((row) => row[domainIndex])
    .filter((item): item is string => typeof item === "string" && item.trim() !== ""); // Remove empty and undefined entries

    // Remove duplicates by converting to a Set and back to an array
    const uniqueDomains = Array.from(new Set(domainData));

    setDropdownItems(uniqueDomains);

    // Set selected item based on `domain` prop if it exists in the unique data
    if (domain && uniqueDomains.includes(domain)) {
      setSelectedItem(domain);
    }
  };  

  // Call loadExcelData once on component mount
  useEffect(() => {
    loadExcelData();
  }, [loadExcelData]);

  // Handle dropdown selection
  const handleSelect = (item: string) => {
    setSelectedItem(item);
    setDomain(item); // Update the domain in the parent component via setDomain
    console.log(domain);
  };

  return (
    <div>
      <DropdownButton id="dropdown-basic-button" title={selectedItem}>
        {dropdownItems.map((item, index) => (
          <Dropdown.Item key={index} onClick={() => handleSelect(item)}>
            {item}
          </Dropdown.Item>
        ))}
      </DropdownButton>

      {/* Display the selected domain */}
      <p>Selected Domain: {domain}</p>
    </div>
  );
};

export default ExcelDropdown;
