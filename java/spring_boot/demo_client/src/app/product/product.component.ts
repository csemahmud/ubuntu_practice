import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  products:any;

  constructor(private service:ProductService) { }

  ngOnInit(): void {
    this.products = this.service.getAllProducts().subscribe(data=>this.products=data);
  }

}
