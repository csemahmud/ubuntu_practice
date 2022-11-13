import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { UserSearchDeleteComponent } from './user-search-delete/user-search-delete.component';

/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */

const routes: Routes = [
  {path:"",redirectTo:"search",pathMatch:"full"},
   {path:"register",component:UserRegistrationComponent},
   {path:"search",component:UserSearchDeleteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
