import { Component } from '@angular/core';
import { IonApp, IonRouterOutlet } from '@ionic/angular/standalone';
import { IonHeader } from '@ionic/angular/standalone';
import { HeaderToolbarComponent } from './shared/components/header-toolbar/header-toolbar.component';
import { addIcons } from 'ionicons';
import {
  book,
  gameController,
  personCircle,
  personCircleOutline,
  podium,
} from 'ionicons/icons';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  imports: [IonApp, IonRouterOutlet, IonHeader, HeaderToolbarComponent],
})
export class AppComponent {
  constructor() {
    addIcons({
      book,
      gameController,
      podium,
      personCircle,
      personCircleOutline,
    });
  }
}
