// Authoren: Franzi,Marc

import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {AlertService} from '../services/alert.service';
import {StockService} from "../services/stock.service";
import {AuthenticationService} from '../services/authentication.service';
import {UserService} from "../services";
import {first} from "rxjs/operators";

@Component({
    selector: 'buy-stock',
    templateUrl: './buy-stock.component.html',
    styleUrls: ['./buy-stock.component.css']
})
export class BuyStockComponent implements OnInit {

    buyStockForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;

    private stockService: StockService;

//
    constructor(private formBuilder: FormBuilder,
                private route: ActivatedRoute,
                private router: Router,

                private alertService: AlertService) {

    }
// Validierung der Felder für BuyStock
    ngOnInit() {
        this.buyStockForm = this.formBuilder.group({
            name: ['', Validators.required],
            quantity: ['', Validators.required],
            wkn: ['', Validators.required],
            type: ['', Validators.required],

        });

        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }
    // hilft
    get f() { return this.buyStockForm.controls; }

    //wenn Form abgegeben, kaufe Stock
    onSubmit() {

        this.submitted = true;


        // wenn fehler
        if (this.buyStockForm.invalid) {
            return;
        }
        this.loading = true;
        this.stockService.buy(this.buyStockForm.value).pipe(first())
            .subscribe(
                data => {
                    this.alertService.success('Kauf erfolgreich', true);
                    this.router.navigate(['/home']);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });


    }

}
