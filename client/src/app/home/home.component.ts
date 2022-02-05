import { Component, OnInit, OnDestroy } from '@angular/core';
import {Router} from '@angular/router';
import {Observable, Subscription} from 'rxjs';
import { first } from 'rxjs/operators';
import {Portfolio, User} from '../models';
import {AuthenticationService, UserService} from '../services';
import {PortfolioService} from '../services/portfolio.service';




@Component({ templateUrl: 'home.component.html' })
export class HomeComponent implements OnInit, OnDestroy {
    currentUser: User;
    currentUserSubscription: Subscription;
    users: User[] = [];
    portfolios: Observable<Portfolio[]>;


    constructor(
        private authenticationService: AuthenticationService,
        private userService: UserService,
        private portfolioService: PortfolioService,
        private router: Router
    ) {
        this.currentUserSubscription = this.authenticationService.currentUser.subscribe(user => {
            this.currentUser = user;
        });
    }

    ngOnInit() {
        this.loadAllUsers();
        this.reloadData();

    }


    ngOnDestroy() {
        // unsubscribe to ensure no memory leaks
        this.currentUserSubscription.unsubscribe();
    }

    deleteUser(id: number) {
        this.userService.delete(id).pipe(first()).subscribe(() => {
            this.loadAllUsers()
        });
    }

    private loadAllUsers() {
        this.userService.getAll().pipe(first()).subscribe(users => {
            this.users = users;
        });
    }





    reloadData() {
        this.portfolios = this.portfolioService.getPortfolioList();
    }

    deletePortfolio(id: number) {
        this.portfolioService.deletePortfolio(id)
            .subscribe(
                data => {
                    console.log(data);
                    this.reloadData();
                },
                error => console.log(error));
    }

    portfolioDetails(id: number){
        this.router.navigate(['details', id]);
    }

    updatePortfolio(id: number){
        this.router.navigate(['update', id]);
    }
}
