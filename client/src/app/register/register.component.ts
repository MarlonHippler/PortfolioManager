import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {first} from 'rxjs/operators';
import {AlertService, AuthenticationService, UserService} from '../services';


@Component(

    {templateUrl: 'register.component.html',
        selector: 'register',})
export class RegisterComponent implements OnInit {
    registerForm: FormGroup;
    loading = false;
    submitted = false;

    constructor(
        private formBuilder: FormBuilder,
        private router: Router,
        private authenticationService: AuthenticationService,
        private userService: UserService,
        private alertService: AlertService
    ) {
        // redirect to home if already logged in
        if (this.authenticationService.currentUserValue) {
            this.router.navigate(['/']);
        }
    }

    ngOnInit() {
        this.registerForm = this.formBuilder.group({
            firstName: ['', Validators.required],
            lastName: ['', Validators.required],
            eMail: ['', Validators.required],
            username: ['', Validators.required],
            password: ['', [Validators.required, Validators.minLength(6)]]
        });
    }

    // convenience getter for easy access to form fields
    get f() {
        return this.registerForm.controls;
    }

    onSubmit() {
        this.submitted = true;

        // stop here if form is invalid
        if (this.registerForm.invalid) {
            return;
        }

        this.loading = true;
        /*  this.userService.register(this.registerForm.value)
              .pipe(first())
              .subscribe( */
        this.userService.register(this.registerForm.value).subscribe(
            (response) => {
                console.log(response);
                /*   data => { */
                this.alertService.success('Registration successful', true);

                this.router.navigateByUrl('/login').then(r => '/login');
            },
            error => {
                this.alertService.error(error);
                this.loading = false;

            });
    }
}

