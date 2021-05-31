import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanetaDetailsComponent } from './planeta-details.component';

describe('PlanetaDetailsComponent', () => {
  let component: PlanetaDetailsComponent;
  let fixture: ComponentFixture<PlanetaDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlanetaDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlanetaDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
