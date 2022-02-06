import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Portfolio} from '../models';
import {PortfolioService} from '../services/portfolio.service';

@Component({
    selector: 'app-portfolio-details',
    templateUrl: './portfolio-details.component.html',
    styleUrls: ['./portfolio-details.component.css']
})
export class PortfolioDetailsComponent implements OnInit {
    id: number;
    portfolio: Portfolio;

    constructor(private route: ActivatedRoute,private router: Router,
                private portfolioService: PortfolioService) { }

    ngOnInit() {
        this.portfolio = new Portfolio();

        this.id = this.route.snapshot.params['id'];

        this.portfolioService.getPortfolio(this.id)
            .subscribe(data => {
                console.log(data)
                this.portfolio = data;
            }, error => console.log(error));
    }

    list(){
        this.router.navigate(['portfolios']);
    }

}
