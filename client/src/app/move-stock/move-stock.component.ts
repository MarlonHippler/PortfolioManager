
import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {AlertService} from '../services/alert.service';
import {AuthenticationService} from '../services/authentication.service';

@Component({
    selector: 'move-stock',
    templateUrl: './move-stock.component.html',
    styleUrls: ['./move-stock.component.css']
})
export class MoveStockComponent implements OnInit {

    moveStockForm: FormGroup;
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
        this.moveStockForm = this.formBuilder.group({
            name: ['', Validators.required],
            quantity: ['', Validators.required],
            wkn: ['', Validators.required],


        });
        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }
    // convenience getter for easy access to form fields
    get f() { return this.moveStockForm.controls; }

    onSubmit() {

        this.submitted = true;


        // stop here if form is invalid
        if (this.moveStockForm.invalid) {
            return;
        }


    }

}
