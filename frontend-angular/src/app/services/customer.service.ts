import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CustomerDTO } from '../models/customer.model';

export interface CustomerSaveRequest {
  customerName: string;
  customerAddress: string;
  customerSalary: number;
  contactNumbers: number;
  nic: string;
}

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  private baseUrl = 'http://localhost:8082/api/v1/customer';

  constructor(private http: HttpClient) {}

  saveCustomer(customer: CustomerSaveRequest): Observable<string> {
    return this.http.post(this.baseUrl + '/save-customer', customer, {
      responseType: 'text',
    });
  }

  getAllCustomers(): Observable<CustomerDTO[]> {
  return this.http.get<CustomerDTO[]>(this.baseUrl + '/get-all-customers');
}


  // You can add other methods like updateCustomer, getCustomerById, etc., later
}
