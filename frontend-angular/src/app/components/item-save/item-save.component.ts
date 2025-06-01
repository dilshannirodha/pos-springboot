import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { RouterModule } from '@angular/router';

@Component({
  standalone: true,
  selector: 'app-item-save',
  imports: [CommonModule, FormsModule,RouterModule],
  templateUrl: './item-save.component.html',
})
export class ItemSaveComponent {
  item = {
    itemName: '',
    measuringUnit: '',
    balanceQty: 0,
    supplierPrice: 0,
    sellingPrice: 0,
    activeState: true
  };

  successMessage: string = '';
  errorMessage: string = '';

  constructor(private http: HttpClient) {}

  saveItem() {
    this.http.post('http://localhost:8082/api/v1/item/save-item', this.item).subscribe({
      next: () => {
        this.successMessage = 'Item saved successfully!';
        this.errorMessage = '';
        this.item = {
          itemName: '',
          measuringUnit: '',
          balanceQty: 0,
          supplierPrice: 0,
          sellingPrice: 0,
          activeState: true
        };
      },
      error: (err) => {
        console.error(err);
        this.errorMessage = 'Failed to save item.';
        this.successMessage = '';
      }
    });
  }
}
