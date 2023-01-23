import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserSearchDeleteComponent } from './user-search-delete.component';

describe('UserSearchDeleteComponent', () => {
  let component: UserSearchDeleteComponent;
  let fixture: ComponentFixture<UserSearchDeleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserSearchDeleteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserSearchDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
