import {Component, OnInit, Output, EventEmitter, Input} from '@angular/core';
import {Router} from '@angular/router';
import {Portfolio} from '../models';
import {PortfolioService} from '../services/portfolio.service';

@Component({
    selector: 'app-create-portfolio-dialog',
    templateUrl: './create-portfolio.component.html',
    styleUrls: ['./create-portfolio.component.css']
})

export class CreatePortfolioComponent implements OnInit {
    portfolio: Portfolio = new Portfolio();
    submitted = false;

    constructor(private portfolioService: PortfolioService,
                private router: Router) { }

    ngOnInit() {
    }

    newPortfolio(): void {
        this.submitted = false;
        this.portfolio = new Portfolio();
    }

    save() {
        this.portfolioService
            .createPortfolio(this.portfolio).subscribe(data => {
                console.log(data)
                this.portfolio = new Portfolio();
                this.gotoList();
            },
            error => console.log(error));
    }

    onSubmit() {
        this.submitted = true;
        this.save();
    }

    gotoList() {
        this.router.navigate(['/portfolios']);
    }
}
