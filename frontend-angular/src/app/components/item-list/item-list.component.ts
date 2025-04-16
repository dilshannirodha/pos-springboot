import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { ItemService } from '../../services/item.service';
import { Item, MeasuringUnit } from '../../models/item.model';

@Component({
  standalone: true,
  selector: 'app-item-list',
  imports: [CommonModule, HttpClientModule],
  templateUrl: './item-list.component.html',
})
export class ItemListComponent implements OnInit {
  items: Item[] = [];
  isLoading = true;
  error: string | null = null;

  measuringUnitLabels: Record<MeasuringUnit, string> = {
    KILO_GRAM: 'kg',
    LITER: 'L',
    GRAM: 'g',
    MILLI_LITER: 'ml',
    NUMBER:'number'
    
  };

  constructor(private itemService: ItemService) {}

  ngOnInit(): void {
    this.itemService.getAllItems().subscribe({
      next: (data) => {
        console.log('Items received from API:', data); 
        this.items = data;
        this.isLoading = false;
      },
      error: (err) => {
        console.error('API Error:', err); 
        this.error = 'Failed to load items';
        this.isLoading = false;
      }
    });
  }
  
}
