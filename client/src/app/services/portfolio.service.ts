import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Portfolio} from '../models';



@Injectable({ providedIn: 'root' })
export class PortfolioService {
    constructor(private http: HttpClient) {
    }

    getAll() {
        return this.http.get<Portfolio[]>(`/portfolios`);
    }

    getById(id: string) {
        return this.http.get<Portfolio>(`portfolios/${id}`);
    }

    create(params: any) {
        return this.http.post('portfolios', params);
    }
}


