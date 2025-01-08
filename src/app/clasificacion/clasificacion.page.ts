import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IonContent, IonHeader } from '@ionic/angular/standalone';
import { HeaderToolbarComponent } from "../header-toolbar/header-toolbar.component";

@Component({
  selector: 'app-clasificacion',
  templateUrl: './clasificacion.page.html',
  styleUrls: ['./clasificacion.page.scss'],
  standalone: true,
  imports: [IonContent, IonHeader, CommonModule, FormsModule, HeaderToolbarComponent]
})
export class ClasificacionPage implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
