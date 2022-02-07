import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {AlertService} from '../services/alert.service';
import {AuthenticationService} from '../services/authentication.service';

/**
 * Sell Stock Component
 *
 * @author  Marc Wortmann, Franzi Arora
 */
@Component({
    selector: 'sell-stock',
    templateUrl: './sell-stock.component.html',
    styleUrls: ['./sell-stock.component.css']
})
export class SellStockComponent implements OnInit {

    sellStockForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;

    constructor(private formBuilder: FormBuilder,
                private route: ActivatedRoute,
                private router: Router,
                private authenticationService: AuthenticationService,
                private alertService: AlertService) {

    }

    ngOnInit() {
        this.sellStockForm = this.formBuilder.group({
            quantity: ['', Validators.required],
            wkn: ['', Validators.required],


        });
        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }
    // convenience getter for easy access to form fields
    get f() { return this.sellStockForm.controls; }

    onSubmit() {

        this.submitted = true;

        // stop here if form is invalid
        if (this.sellStockForm.invalid) {
            return;
        }


    }

}
