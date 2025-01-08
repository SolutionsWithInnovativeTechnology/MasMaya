import { Component, OnInit } from '@angular/core';
import { IonTitle, IonToolbar } from '@ionic/angular/standalone';

@Component({
  selector: 'app-header-toolbar',
  templateUrl: './header-toolbar.component.html',
  styleUrls: ['./header-toolbar.component.scss'],
  standalone: true,
  imports: [IonTitle, IonToolbar]
})
export class HeaderToolbarComponent  implements OnInit {

  constructor() { }

  ngOnInit() {}

}
