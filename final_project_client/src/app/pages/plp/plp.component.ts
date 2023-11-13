import {Component, OnInit} from '@angular/core';
import {AsyncPipe, JsonPipe} from '@angular/common';
import {PlpData} from "../../models/responce/product/plp.data";
import { Observable} from "rxjs";
import {PlpService} from "../../services/plp.service";

@Component({
  selector: 'app-plp',
  standalone: true,
  templateUrl: './plp.component.html',
  imports: [
    JsonPipe,
    AsyncPipe
  ],
  styleUrls: ['./plp.component.scss'],
  providers: [PlpService]
})

export class PlpComponent implements OnInit {

  products$: Observable<PlpData[]> = this.service
    .loadProducts();

  constructor(private service: PlpService) {
  }

  ngOnInit(): void {}

}
