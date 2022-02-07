import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Stock} from '../models/stock';

@Injectable({ providedIn: 'root' })
export class StockService {
    private baseUrl="http://localhost:8080";
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<Stock[]>(`/users`);
    }

    buy(stock: Stock) {
        return this.http.post(`${this.baseUrl}/api/v1/buyStock`, stock);
    }

    sell(stock: Stock) {

        return this.http.delete(`/stocks/bought'${stock}`);
    }
}
