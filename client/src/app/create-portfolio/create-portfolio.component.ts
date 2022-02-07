import {Component, OnInit, Output, EventEmitter, Input} from '@angular/core';
import {Router} from '@angular/router';
import {Portfolio} from '../models';
import {PortfolioService} from '../services/portfolio.service';


//Authoren: Marc, Franzi

@Component({
    selector: 'add',
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

// Neues Portfolio anlegen
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
