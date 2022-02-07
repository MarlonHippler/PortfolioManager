import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';

import {AppComponent} from './app.component';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {CreatePortfolioComponent} from './create-portfolio/create-portfolio.component';
import {ErrorInterceptor} from './helpers/error.interceptor';

import {JwtInterceptor} from './helpers/jwt.interceptor';
import {LoginComponent} from './login/login.component';



import {BuyStockComponent} from "./buy-stock/buy-stock.component";
import{SellStockComponent} from "./sell-stock-dialog/sell-stock.component";
import {MoveStockComponent} from "./move-stock/move-stock.component";

import {RegisterComponent} from './register/register.component';
import {HomeComponent} from './home/home.component';
import {AlertComponent} from './alert/alert.component';
import { PortfolioDetailsComponent } from './portfolio-details/portfolio-details.component';



@NgModule({
    declarations: [
        AppComponent,

        RegisterComponent,

        LoginComponent,


        CreatePortfolioComponent,
        BuyStockComponent,

        RegisterComponent,
        HomeComponent,
        AlertComponent,
        SellStockComponent,
        MoveStockComponent,
        PortfolioDetailsComponent


    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpClientModule,
        AppRoutingModule,
        ReactiveFormsModule
    ],
    providers: [
        {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
        {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true},



    ],
    bootstrap: [AppComponent]
})
export class AppModule {
};
