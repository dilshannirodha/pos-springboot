import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Item } from '../models/item.model';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ItemService {
  private baseUrl = 'http://localhost:8082/api/v1/item';

  constructor(private http: HttpClient) {}

  getAllItems(): Observable<Item[]> {
    return this.http.get<{ code: number, message: string, data: Item[] }>(`${this.baseUrl}/get-all-items`)
      .pipe(map(res => res.data));
  }

  saveItem(item: Item): Observable<any> {
    return this.http.post(`${this.baseUrl}/save-item`, item);
  }
}
