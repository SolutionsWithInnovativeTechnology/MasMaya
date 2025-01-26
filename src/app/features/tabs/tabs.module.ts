import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TabsPage } from './tabs.page';
import { TabsPageRoutingModule } from './tabs-routing.module';
import { IonTabs, IonTabBar, IonTabButton, IonIcon, IonLabel } from '@ionic/angular/standalone';
import { HeaderToolbarComponent } from 'src/app/shared/components/header-toolbar/header-toolbar.component';

@NgModule({
  imports: [
    CommonModule,
    TabsPageRoutingModule,  
    IonTabs,
    IonTabBar,
    IonTabButton,
    IonIcon,
    IonLabel,
    HeaderToolbarComponent,
  ],
  declarations: [TabsPage],
  exports: [TabsPage], 
})
export class TabsModule {}
