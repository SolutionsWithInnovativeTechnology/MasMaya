import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import { HeaderToolbarComponent } from '../../shared/components/header-toolbar/header-toolbar.component';
import { RouterLink } from '@angular/router';

interface JuegoButton {
  title: string;
  bgImage: string;
  route: string
}

@Component({
  selector: 'app-juegos',
  templateUrl: './juegos.page.html',
  styleUrls: ['./juegos.page.scss'],
  standalone: true,
  imports: [IonicModule, CommonModule, RouterLink, HeaderToolbarComponent]
})
export class JuegosPage implements OnInit {
  juegosBtns: JuegoButton[] = [
    { title: 'Números', bgImage: 'assets/img/juegos/bg-categorias/numeros.webp', route: 'numeros' },
    { title: 'Frutas', bgImage: 'assets/img/juegos/bg-categorias/frutas.webp', route: 'frutas' },
    { title: 'Animales', bgImage: 'assets/img/juegos/bg-categorias/animales.webp', route: 'animales' },
    { title: 'Frases Comunes', bgImage: 'assets/img/juegos/bg-categorias/frases.webp', route: 'frases' },
  ];

  constructor() { }

  ngOnInit() {
  }

}
