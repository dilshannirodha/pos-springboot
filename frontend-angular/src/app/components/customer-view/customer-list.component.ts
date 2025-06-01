import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { CustomerService } from '../../services/customer.service';
import { CustomerDTO } from '../../models/customer.model'; 
import { RouterModule } from '@angular/router';


@Component({
  selector: 'app-customer-list',
  standalone: true,
  imports: [CommonModule, HttpClientModule,RouterModule],
  templateUrl: './customer-list.component.html',  // external template file
})
export class CustomerListComponent implements OnInit {
  customers: CustomerDTO[] = [];
  isLoading = false;
  error: string | null = null;

  constructor(private customerService: CustomerService) {}

  ngOnInit(): void {
    this.loadCustomers();
  }

  loadCustomers() {
    this.isLoading = true;
    this.error = null;

    this.customerService.getAllCustomers().subscribe({
      next: (data) => {
        this.customers = data;
        this.isLoading = false;
      },
      error: (err) => {
        this.error = 'Failed to load customers';
        this.isLoading = false;
        console.error('Customer API error:', err);
      }
    });
  }
}
