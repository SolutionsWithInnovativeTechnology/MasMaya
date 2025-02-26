import { Component, EnvironmentInjector, inject } from '@angular/core';
import { ScreenSizeService } from 'src/app/services/screen-size-service.service';

@Component({
  selector: 'app-tabs',
  templateUrl: './tabs.page.html',
  styleUrls: ['./tabs.page.scss'],
  standalone: false,
})
export class TabsPage {
  public environmentInjector = inject(EnvironmentInjector);
  isLargeScreen: boolean = false;

  constructor(private screenSizeService: ScreenSizeService) {
    this.screenSizeService.isLargeScreen$.subscribe((isLargeScreen) => {
      this.isLargeScreen = isLargeScreen;
    });
  }
}
