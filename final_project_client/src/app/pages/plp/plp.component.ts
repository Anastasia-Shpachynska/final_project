import {Component, OnInit} from '@angular/core';
import {AsyncPipe, CommonModule, NgIf} from '@angular/common';
import {PlpService} from "../../services/plp.service";
import {Observable} from "rxjs";
import {PlpData} from "../../models/responce/product/plp.data";


@Component({
  selector: 'app-plp',
  standalone: true,
  imports: [CommonModule, NgIf, AsyncPipe],
  templateUrl: './plp.component.html',
  styleUrls: ['./plp.component.scss'],
})
export class PlpComponent implements OnInit{

  products$: Observable<PlpData[]> = this.service
      .loadProducts();

  constructor(private service: PlpService) { }

  ngOnInit(): void {}
}
