import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IonContent, IonHeader, IonGrid, IonCardHeader, IonCard, IonButton, IonCardContent, IonCardTitle, IonCol, IonRow } from '@ionic/angular/standalone';
import { HeaderToolbarComponent } from '../../shared/components/header-toolbar/header-toolbar.component';

@Component({
  selector: 'app-juegos',
  templateUrl: './juegos.page.html',
  styleUrls: ['./juegos.page.scss'],
  standalone: true,
  imports: [IonRow, IonCol, IonCardTitle, IonCardContent, IonButton, IonCard, IonCardHeader, IonGrid, IonContent, IonHeader, CommonModule, FormsModule]
})
export class JuegosPage implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
