import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

@Component({
  selector: 'app-user-search-delete',
  templateUrl: './user-search-delete.component.html',
  styleUrls: ['./user-search-delete.component.css']
})
export class UserSearchDeleteComponent implements OnInit {

  users:any;
  email:string = "";
  message:any;

  constructor(private service: UserService){}

  public deleteUser(id:number){
    let response1 = this.service.deleteUser(id);
    let response2 = this.service.getAllUsers();
    this.users = null;
    response1.subscribe((data) => this.message = data);
    response2.subscribe((data) => this.users = data);
  }

  public findUserByEmailId(){
    let response = this.service.getUserByEmail(this.email);
    this.users = Array();
    response.subscribe((data) => this.users[0] = data);
  }

  ngOnInit(): void {
    let response = this.service.getAllUsers();
    response.subscribe((data) => this.users = data);
  }

}
