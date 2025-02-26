import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ScreenSizeService {
  private isLargeScreenSubject = new BehaviorSubject<boolean>(window.innerWidth >= 768);

  // Observable para que se pueda suscribir cualquier componente
  isLargeScreen$ = this.isLargeScreenSubject.asObservable();

  constructor() {
    window.addEventListener('resize', () => this.updateScreenSize());
  }

  private updateScreenSize() {
    this.isLargeScreenSubject.next(window.innerWidth >= 768);
  }
}
