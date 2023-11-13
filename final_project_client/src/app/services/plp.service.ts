import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {PlpData} from "../models/responce/product/plp.data";
import {ResponceData} from "../models/responce/responce.data";

@Injectable({
  providedIn: 'root'
})
export class PlpService {

  constructor(private http: HttpClient) { }

  loadProducts(): Observable<PlpData[]> {
    return this.http.get<ResponceData<PlpData[]>>('http://localhost:8080/api/open/products')
        .pipe(
            map(res => res.data)
        );
  }
}
