import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {

  user: User=new User("","","",0,0,0);
  message:any;

  constructor(private service:UserService) { }

  ngOnInit(): void {
  }

  public registerNow(){
    
    let response=this.service.doRegistration(this.user);
    response.subscribe((data)=>this.message=data);
  
  }

}
