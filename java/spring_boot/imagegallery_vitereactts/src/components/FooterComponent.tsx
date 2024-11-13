// src/components/HeaderComponent.tsx
import React from 'react';
import { Navbar, Container } from 'react-bootstrap';

const FooterComponent: React.FC = () => {
  return (
    <Navbar bg="light" variant="light" expand="lg" fixed="bottom" className='footer'>
      <Container>
        <span>All rights reserved 2024 by ©lone.wolf.mahmud@gmail.com</span>
      </Container>
    </Navbar>
  );
};

export default FooterComponent;
