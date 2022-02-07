import { Routes, RouterModule } from '@angular/router';
import {AuthGuard} from './guards/auth.guard';
import {LoginComponent} from "./login/login.component";
import {ManagementComponent} from './management/management/management.component';
import {RegisterComponent} from './register/register.component';
import {NavComponent} from "./nav/nav.component";
import {HomeComponent} from "./home";
import {CreatePortfolioComponent} from "./create-portfolio";


const appRoutes: Routes = [
    { path: '', component: ManagementComponent, canActivate: [AuthGuard] },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'app-nav', component: NavComponent },
    { path: 'portfolios', component: HomeComponent},
    { path: 'add', component: CreatePortfolioComponent},
    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);
