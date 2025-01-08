import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IonContent, IonHeader, IonToolbar, IonTitle } from '@ionic/angular/standalone';
import { HeaderToolbarComponent } from '../header-toolbar/header-toolbar.component';

@Component({
  selector: 'app-historia',
  templateUrl: './historia.page.html',
  styleUrls: ['./historia.page.scss'],
  standalone: true,
  imports: [IonTitle, IonToolbar, IonContent, IonHeader, CommonModule, FormsModule, HeaderToolbarComponent]
})
export class HistoriaPage implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
