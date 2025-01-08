import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IonContent, IonHeader } from '@ionic/angular/standalone';
import { HeaderToolbarComponent } from "../header-toolbar/header-toolbar.component";

@Component({
  selector: 'app-juegos',
  templateUrl: './juegos.page.html',
  styleUrls: ['./juegos.page.scss'],
  standalone: true,
  imports: [IonContent, IonHeader, CommonModule, FormsModule, HeaderToolbarComponent]
})
export class JuegosPage implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
