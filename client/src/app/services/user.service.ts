import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {User} from '../models/user';

@Injectable({ providedIn: 'root' })
export class UserService {
    private baseUrl="http://localhost:8080";
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<User[]>(`${this.baseUrl}/users`);
    }

    register(user: User) {
        console.log(user);
        return this.http.post(`${this.baseUrl}/api/v1/registration`, user);

    }

    delete(id: number) {
        return this.http.delete(`${this.baseUrl}/users/${id}`);
    }
}
