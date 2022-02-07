import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CreatePortfolioComponent} from './create-portfolio/create-portfolio.component';
import {AuthGuard} from './helpers/auth.guard';
import {HomeComponent} from './home/home.component';
import {LoginComponent} from './login/login.component';
import {PortfolioDetailsComponent} from './portfolio-details/portfolio-details.component';
import {RegisterComponent} from './register/register.component';

const routes: Routes = [
    {path:'login', component:LoginComponent},
    {path:'register', component:RegisterComponent},
    {path:'add', component: CreatePortfolioComponent},
    {path: 'details/:id', component: PortfolioDetailsComponent },
    {path:'portfolios', component: HomeComponent},
    { path: '', component: HomeComponent, canActivate: [AuthGuard]}];


@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
