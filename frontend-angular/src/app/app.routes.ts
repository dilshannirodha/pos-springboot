import { Routes } from '@angular/router';
import { ItemListComponent } from './components/item-list/item-list.component';
import { ItemSaveComponent } from './components/item-save/item-save.component';
import { SaveCustomerComponent } from './components/customer/save-customer.component';
import { CustomerListComponent } from './components/customer-view/customer-list.component';
import { NavbarComponent } from './components/navbar/navbar.component';

export const routes: Routes = [
    { path: '', component: NavbarComponent  },
    { path: 'view-item', component: ItemListComponent },
    { path: 'add-item', component: ItemSaveComponent },
    { path: 'add-customer', component: SaveCustomerComponent }, 
    { path: 'view-customer', component: CustomerListComponent }
];
