import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  public doRegistration(user:User){
    return this.http.post("http://localhost:9191/addUser",user,{responseType:'text' as 'json'});
  }

  getAllUsers(){
    return this.http.get("http://localhost:9191/users");;
  }

  public getUserByEmail(email:String){
    return this.http.get("http://localhost:9191/userByEmail/"+email);
  }

  public deleteUser(id:number){
    return this.http.delete("http://localhost:9191/delete/"+id);
  }
}
