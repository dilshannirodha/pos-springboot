import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { CustomerService, CustomerSaveRequest } from '../..//services/customer.service';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-save-customer',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule,RouterModule],
  templateUrl: './save-customer.component.html',
})
export class SaveCustomerComponent {
  customer: CustomerSaveRequest = {
    customerName: '',
    customerAddress: '',
    customerSalary: 0,
    contactNumbers: 0,
    nic: '',
  };

  successMessage = '';
  errorMessage = '';

  constructor(private customerService: CustomerService, private router: Router) {}

  saveCustomer() {
    this.customerService.saveCustomer(this.customer).subscribe({
      next: (res) => {
        this.successMessage = 'Customer saved successfully! ID: ' + res;
        this.errorMessage = '';
        this.customer = {
          customerName: '',
          customerAddress: '',
          customerSalary: 0,
          contactNumbers: 0,
          nic: '',
        };
      },
      error: () => {
        this.errorMessage = 'Failed to save customer.';
        this.successMessage = '';
      },
    });
  }
}
