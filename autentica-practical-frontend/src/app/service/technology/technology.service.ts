import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TechnologyService {

  get technologyTypes() : Array<string> {
    return [ 'desktop', 'laptop', 'tablet', 'phone'];
  }

  get technologyRAM() : Array<number> {
    return [2, 4, 8, 16, 32, 64, 128];
  }

  get technologyCores() : Array<number> {
    return [1, 2, 4, 6, 8, 16, 32, 64, 128];
  }

  technologyMotherboards(type: string) : Array<string> {
    switch (type) {
      case 'desktop':
        return [
          'motherboard_desktop_1',
          'motherboard_desktop_2',
          'motherboard_desktop_3',
        ];
      case 'laptop':
        return [
          'motherboard_laptop_1',
          'motherboard_laptop_2',
          'motherboard_laptop_3',
        ];
      case 'tablet':
        return [
          'motherboard_tablet_1',
          'motherboard_tablet_2',
          'motherboard_tablet_3',
        ];
      case 'phone':
        return [
          'motherboard_phone_1',
          'motherboard_phone_2',
          'motherboard_phone_3',
        ];
      default:
        return [];
    }
  }

  technologyGPU(type: string) : Array<string> {
    switch (type) {
      case 'desktop':
        return [
          'gpu_desktop_1',
          'gpu_desktop_2',
          'gpu_desktop_3',
        ];
      case 'laptop':
        return [
          'gpu_laptop_1',
          'gpu_laptop_2',
          'gpu_laptop_3',
        ];
      case 'tablet':
        return [
          'gpu_tablet_1',
          'gpu_tablet_2',
          'gpu_tablet_3',
        ];
      case 'phone':
        return [
          'gpu_phone_1',
          'gpu_phone_2',
          'gpu_phone_3',
        ];
      default:
        return [];
    }
  }
}
