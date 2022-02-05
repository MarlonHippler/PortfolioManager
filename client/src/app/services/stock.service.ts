import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Stock} from '../models/stock';

@Injectable({ providedIn: 'root' })
export class StockService {
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<Stock[]>(`/users`);
    }

    buy(stock: Stock) {
        return this.http.post(`/stocks/bought`, stock);
    }

    sell(stock: Stock) {

        return this.http.delete(`/stocks/bought'${stock}`);
    }
}
