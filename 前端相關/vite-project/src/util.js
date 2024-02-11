
/**
 * 
 * @param {number} width 
 * @param {number} height 
 * @returns {string}
 */
export function getImageUrl(width, height) {
    return `https://picsum.photos/${width}/${height}?random=${rand(1,99)}`;
}

export function rand(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

export function formatDate(date) {
    return new Intl.DateTimeFormat(
      'zh-CN',
      { year: 'numeric', month: 'long', day: 'numeric',weekday: 'long' }
    ).format(date);
}
  