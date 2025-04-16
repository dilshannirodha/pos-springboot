import { Routes } from '@angular/router';
import { ItemListComponent } from './components/item-list/item-list.component';
import { ItemSaveComponent } from './components/item-save/item-save.component';

export const routes: Routes = [
    { path: '', component: ItemListComponent },
    { path: 'add-item', component: ItemSaveComponent }
];
