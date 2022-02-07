import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';



@Injectable({ providedIn: 'root' })
export class PortfolioService {

    private baseUrl = 'http://localhost:8080/';

    constructor(private http: HttpClient) { }

    getPortfolio(id: number): Observable<any> {
        return this.http.get(`${this.baseUrl}/${id}`);
    }

    createPortfolio(portfolio: Object): Observable<Object> {
        return this.http.post(`${this.baseUrl}api/v1/createPortfolio`, portfolio);
    }

    updatePortfolio(id: number, value: any): Observable<Object> {
        return this.http.put(`${this.baseUrl}${id}`, value);
    }

    deletePortfolio(id: number): Observable<any> {
        return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
    }

    getPortfolioList(): Observable<any> {
        return this.http.get(`${this.baseUrl}api/v1/listPortfolios`);
    }
}
