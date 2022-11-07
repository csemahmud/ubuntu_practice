import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }

  getAllProducts(){
    return this.http.get("http://localhost:9191/products");;
  }
}
