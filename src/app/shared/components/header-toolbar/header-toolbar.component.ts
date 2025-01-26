import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterModule } from '@angular/router';
import {
  IonButton,
  IonButtons,
  IonIcon,
  IonText,
  IonTitle,
  IonToolbar,
} from '@ionic/angular/standalone';

import { ScreenSizeService } from 'src/app/screen-size-service.service';

@Component({
  selector: 'app-header-toolbar',
  templateUrl: './header-toolbar.component.html',
  styleUrls: ['./header-toolbar.component.scss'],
  standalone: true,
  imports: [
    IonText,
    IonIcon,
    IonButtons,
    IonButton,
    IonTitle,
    IonToolbar,
    CommonModule,
    RouterLink,
    RouterModule,
  ],
})
export class HeaderToolbarComponent implements OnInit {
  isLargeScreen: boolean = false;
  constructor(private screenSizeService: ScreenSizeService) {
  }

  ngOnInit() {
    this.screenSizeService.isLargeScreen$.subscribe((isLargeScreen) => {
      this.isLargeScreen = isLargeScreen;
    });
  }
}
